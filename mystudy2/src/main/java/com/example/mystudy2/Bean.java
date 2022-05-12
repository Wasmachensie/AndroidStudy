package com.example.mystudy2;

public class Bean {
    private String name;
    private int avatars;
    private String dialog;

    public Bean() {
    }

    public Bean(String name, int avatars, String dialog) {
        this.name = name;
        this.avatars = avatars;
        this.dialog = dialog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvatars() {
        return avatars;
    }

    public void setAvatars(int avatars) {
        this.avatars = avatars;
    }

    public String getDialog() {
        return dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }
}
