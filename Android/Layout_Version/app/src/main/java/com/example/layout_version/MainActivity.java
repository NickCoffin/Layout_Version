package com.example.layout_version;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    public static int background_color1;
    public static int background_color2;

    public ConstraintLayout main_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView btn;
        Button lib;
        Button con;
        ImageView pol;

        ConstraintLayout constraintLayout = findViewById(R.id.main_layout);
        System.out.println("*******************\n\n\n" + constraintLayout);

        background_color1 = Color.DKGRAY;
        background_color2 = Color.WHITE;

        main_layout = new ConstraintLayout(this);
        main_layout.setLayoutParams(createLayoutParams(0, 0, 0, 0, -1, -1 ));
        constraintLayout.addView(main_layout);

        ConstraintLayout camera_layout = construct_camera_layout(main_layout);

        btn = (ImageView) findViewById(R.id.settings);
        lib = (Button) findViewById(R.id.library);
        con = (Button) findViewById(R.id.connect);
        pol = (ImageView) findViewById(R.id.policy);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this,Settings.class);
                startActivity(intent);
            }
        });

        lib.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this,Library.class);
                startActivity(intent);
            }
        });
        con.setOnClickListener(new View.OnClickListener()
        {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent (MainActivity.this,Connect.class);
               startActivity(intent);
           }
        });
        pol.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this,Policy.class);
                startActivity(intent);
            }
        });
    }

    public ConstraintLayout construct_camera_layout(ConstraintLayout main_layout){
        int width = get_width_of_screen();

        int border_color = Color.BLACK;

        ConstraintLayout camera_layout = new ConstraintLayout(this);
        camera_layout.setLayoutParams(createLayoutParams(0, 0, 0, 0, -1, -1));
        main_layout.addView(camera_layout);
        //camera_layout.setVisibility(View.INVISIBLE);
        int camera_vertical_start = 200;
        int camera_width = (int)(width*0.8);
        int camera_height = (int)(camera_width * 0.62);
        int camera_padding = 100;

        View background = fill_rectangle(background_color2);
        background.setLayoutParams(createLayoutParams(0, 0, 0, 0, -1, -1));
        camera_layout.addView(background);

        ScrollView scroll = new ScrollView(this);
        scroll.setLayoutParams(createLayoutParams(200, 0, 100, 100, -1, -1));
        camera_layout.addView(scroll);

        ConstraintLayout scroll_container = new ConstraintLayout(this);
        scroll.addView(scroll_container);

        ConstraintLayout[] layouts = new ConstraintLayout[4];
        for(int i = 0; i < layouts.length; i++){
            ConstraintLayout constraintLayout_camera1 = new ConstraintLayout(this);
            constraintLayout_camera1.setLayoutParams(createLayoutParams(100 + (camera_height + camera_padding) * i, -1, 0, 0, camera_width, camera_height));
            scroll_container.addView(constraintLayout_camera1);
            layouts[i] = constraintLayout_camera1;
        }

        for(int i = 0; i < layouts.length; i++){
            View border = rectangle(border_color, 15);
            border.setLayoutParams(createLayoutParams(0, 0, 0, 0, -1, -1));
            View fill = fill_rectangle(background_color1);
            fill.setLayoutParams(createLayoutParams(0, 0, 0, 0, -1, -1));
            layouts[i].addView(fill);
            layouts[i].addView(border);

            Button settings = new Button(this);
            settings.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            settings.setLayoutParams(createLayoutParams(50, -1, 50, -1, 100, 100));
            layouts[i].addView(settings);
        }
        return camera_layout;
    }

    public int get_width_of_screen(){
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);

        int screenWidth = dm.widthPixels;
        int screenHeight = dm.heightPixels;
        return screenWidth;
    }

    public View rectangle(int color, int thickness){
        return new View(this){
            @Override
            protected void onDraw(Canvas canvas) {
                int padding = 0;

                System.out.println("bounds: " + canvas.getClipBounds());
                float radius = 20.0f;


                int left = padding + thickness/2;//getLeft() + 50;
                int top = padding + thickness/2;//getTop() + 50;
                int right = getRight() - getLeft() - 2*padding - thickness/2;
                int bottom = getBottom() - getTop() - 2*padding - thickness/2;

                Paint paint_fill_blue = paint_stroke(color, thickness);

                RectF rect_blue = new RectF(left, top, right, bottom);//(int)(getRight()-getLeft()-2*thickness), (int)(getBottom()-getTop()-2*thickness));
                canvas.drawRect(rect_blue, paint_fill_blue);
            }

        };
    }

    public static Paint paint_fill(int color){
        Paint paint = new Paint();
        paint.setColor(color);
        //paint.setAlpha(128);
        return paint;
    }

    public static Paint paint_stroke(int color, int thickness){
        Paint paint_stroke = new Paint();
        paint_stroke.setStyle(Paint.Style.STROKE);
        paint_stroke.setStrokeWidth(thickness);
        paint_stroke.setColor(color);
        //paint_stroke.setAlpha(128);
        return paint_stroke;
    }

    public static ConstraintLayout.LayoutParams createLayoutParams(
            int top, int  bottom, int right, int left,
            int width, int height
    ){
        // Create a new ConstraintLayout.LayoutParams object
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
        );

        // Set the view's layout parameters

        // Set the constraints for the view
        if(left != -1)
            layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        if(top != -1)
            layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        if(right != -1)
            layoutParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        if(bottom != -1)
            layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;

        // Set the view's margin
        int margin = 16; // in pixels
        layoutParams.setMargins(left, top, right, bottom);
        layoutParams.width = width;
        layoutParams.height = height;
        return layoutParams;
    }

    public View fill_rectangle(int color){
        return new View(this){
            @Override
            protected void onDraw(Canvas canvas) {
                int padding = 0;

                System.out.println("bounds: " + canvas.getClipBounds());
                float radius = 20.0f;


                int left = padding;//getLeft() + 50;
                int top = padding;//getTop() + 50;
                int right = getRight() - getLeft() - 2*padding;
                int bottom = getBottom() - getTop() - 2*padding;

                Paint paint_fill_blue = paint_fill(color);

                RectF rect_blue = new RectF(left, top, right, bottom);//(int)(getRight()-getLeft()-2*thickness), (int)(getBottom()-getTop()-2*thickness));
                canvas.drawRect(rect_blue, paint_fill_blue);}

        };
    }

}