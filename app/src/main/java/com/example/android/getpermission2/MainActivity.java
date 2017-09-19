package com.example.android.getpermission2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final int PERMISSION_CODE_CAMERA = 1;
    private final int START_CAREMA_CODE = 2;

    private Button btn_get_camera_permission;

    private String tempPhotoPath;//照相后保存路径

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_get_camera_permission = (Button) findViewById(R.id.btn_get_camera_permission);
        btn_get_camera_permission.setOnClickListener(this);

        tempPhotoPath = Environment.getExternalStorageState() + File.separator + "photo.jpg";
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_get_camera_permission:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN &&
                        !PermissionUtils.permissionIsOpen(MainActivity.this, Manifest.permission.CAMERA)) {
                    PermissionUtils.getPermission(MainActivity.this, Manifest.permission.CAMERA, PERMISSION_CODE_CAMERA);
                } else {
                    //执行拍照操作
                }

                break;
        }
    }


}
