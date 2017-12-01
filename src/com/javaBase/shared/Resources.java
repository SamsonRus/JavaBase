package com.javaBase.shared;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface Resources extends ClientBundle {
    public static final Resources INSTANCE =  GWT.create(Resources.class);

    @Source("img/add_button.png")
    ImageResource add_button();

    @Source("img/edit_button.png")
    ImageResource edit_button();

    @Source("img/delete_button.png")
    ImageResource delete_button();

    @Source("img/save_button.png")
    ImageResource save_button();

    //Из 1с
    @Source("img/icons/add.png")
    ImageResource add();

    @Source("img/icons/calendar.png")
    ImageResource calendar();

    @Source("img/icons/cancel_search.png")
    ImageResource cancel_search();

    @Source("img/icons/check.png")
    ImageResource check();

    @Source("img/icons/clear.png")
    ImageResource clear();

    @Source("img/icons/copy.png")
    ImageResource copy();

    @Source("img/icons/delete.png")
    ImageResource delete();

    @Source("img/icons/edit.png")
    ImageResource edit();

    @Source("img/icons/help.png")
    ImageResource help();

    @Source("img/icons/image.png")
    ImageResource image();

    @Source("img/icons/move_down.png")
    ImageResource move_down();

    @Source("img/icons/move_left.png")
    ImageResource move_left();

    @Source("img/icons/move_right.png")
    ImageResource move_right();

    @Source("img/icons/move_up.png")
    ImageResource move_up();

    @Source("img/icons/open.png")
    ImageResource open();

    @Source("img/icons/pass.png")
    ImageResource pass();

    @Source("img/icons/print.png")
    ImageResource print();

    @Source("img/icons/refresh.png")
    ImageResource refresh();

    @Source("img/icons/rename.png")
    ImageResource rename();

    @Source("img/icons/save.png")
    ImageResource save();

    @Source("img/icons/search.png")
    ImageResource search();

    @Source("img/icons/uncheck.png")
    ImageResource uncheck();

    @Source("img/icons/user.png")
    ImageResource user();

}
