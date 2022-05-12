package com.example.myrx.simple01;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myrx.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    //打印Log日志
    private static final String TAG = MainActivity.class.getSimpleName();

    //网路图片地址
    private static final String Path = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.jj20.com%2Fup%2Fallimg%2F1113%2F052420110515%2F200524110515-2-1200.jpg&refer=http%3A%2F%2Fimg.jj20.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1654826200&t=d7d9a56f3733b6d2e938e7436aa75dec";
    private static final String TGA = "ARNO";

    //弹出加载框 (正在加载中...)
    private ProgressDialog progressDialog;

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
    }

    /**
     * 显示图片加载功能
     * RX思维：
     * 起点和终点：
     * 1.起点：创建被观察者（Observable）
     * 2.终点：创建观察者（Observer）
     *
     * RXJava ... RX系列框架把所有函数称为操作符：所有的函数要去操作从起点流向终点
     * @param view
     */
    public void showImageAction(View view) {
        // TODO 第二步
        //1.起点：创建被观察者（Observable）
        Observable.just(Path)
                // TODO 第三步
                /*
                * 现在在起点和终点之间插入需求001：下载图片
                * 上一层格式是String 下一层格式是Bitmap
                * */
                .map(new Function<String, Bitmap>() {
                    @Override
                    public Bitmap apply(String path) throws Throwable {
                        //Thread.sleep(3000);//模拟睡眠3秒
                        URL url = new URL(path);
                        HttpURLConnection httpURL = (HttpURLConnection) url.openConnection();
                        //设置请求连接时常5s
                        httpURL.setConnectTimeout(5000);
                        //拿到服务器响应
                        int responseCode = httpURL.getResponseCode();
                        if (responseCode == HttpURLConnection.HTTP_OK) {
                            //拿到图片
                            InputStream inputStream = httpURL.getInputStream();
                            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            return bitmap;
                        }
                        return null;
                    }
                })
                /*
                * 新添加需求002：给图片添加水印
                * */
                .map(new Function<Bitmap, Bitmap>() {
                    @Override
                    public Bitmap apply(Bitmap bitmap) throws Throwable {
                        //画笔属性设置
                        Paint paint = new Paint();
                        paint.setColor(Color.RED);//设置颜色
                        paint.setTextSize(50);//设置字体大小
                        Bitmap shuiYBitmap = drawTextToBitmap(bitmap, "要添加的水印", paint, 88, 88);
                        return shuiYBitmap;
                    }
                })
                /*
                * 新添加需求003：日志打印
                * */
                .map(new Function<Bitmap, Bitmap>() {
                    @Override
                    public Bitmap apply(Bitmap bitmap) throws Throwable {
                        Log.e(TGA,"什么时候下载了图片:"+System.currentTimeMillis());
                        return bitmap;
                    }
                })

                //给上游分配异步线程（图片下载操作）
                .subscribeOn(Schedulers.io())

                //给下游分配异步线程（图片显示操作）
                .observeOn(AndroidSchedulers.mainThread())

                // TODO 类似于导火索点燃了，现在开始执行
                //关联起点和终点 == 订阅  观察者设计模式
                //2.终点：创建观察者（Observer）
                .subscribe(new Observer<Bitmap>() {
                    // TODO 第一步
                    @Override
                    //订阅成功
                    public void onSubscribe(Disposable d) {
                        //弹出加载框
                        progressDialog = new ProgressDialog(MainActivity.this);
                        progressDialog.setTitle("RXJava ARNO 正在加载中...");
                        progressDialog.show();
                    }
                    // TODO 第四步  图片显示
                    @Override
                    //上一层给的数据
                    //上一层是String，下一层就是String
                    //上一层是Bitmap，下一层就是Bitmap
                    public void onNext(@NonNull Bitmap bitmap) {
                        //拿到上层传过来的数据显示在控件上
                        imageView.setImageBitmap(bitmap);
                    }
                    @Override
                    //链条思维发生异常
                    public void onError(@NonNull Throwable e) {
                    }
                    // TODO 第五步
                    @Override
                    //链条思维结束
                    public void onComplete() {
                        //隐藏加载框
                        if (progressDialog != null) {
                            progressDialog.dismiss();
                        }
                    }
                });
    }

    //图片上绘制文字加水印
    private final Bitmap drawTextToBitmap(Bitmap bitmap, String text, Paint paint,
                                          int paddingLeft,int paddingTop) {
        Bitmap.Config bitmapConfig = bitmap.getConfig();
        paint.setDither(true); // 获取跟清晰的图像采样
        paint.setFilterBitmap(true);// 过滤一些
        paint.setAntiAlias(true);// 边缘光滑，去掉锯齿
        if (bitmapConfig == null) {
            bitmapConfig = Bitmap.Config.ARGB_8888;
        }
        bitmap = bitmap.copy(bitmapConfig, true);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawText(text, paddingLeft, paddingTop, paint);
        return bitmap;
    }

    /**
     * 常用操作符
     * 思维和上面.just()是一样的
     * @param view
     */
    public void showAction(View view) {
        String[] strings = {"AAA", "BBB", "CCC"};
        //起点 创建被观察者
        Observable.fromArray(strings)
                //关联起点和终点 == 订阅
                //2.终点：创建观察者（Observer）
                //简化版的订阅
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Throwable {
                        Log.e(TGA, "接收到的数据：" + s);
                    }
                });
    }
}