package com.example.android.getpermission2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

/**
 * 获取拍照权限
 * Created by ruxing on 2017/9/19.
 */

public class PermissionUtils {

    public static boolean permissionIsOpen(Activity activity, String permission){
        if(ContextCompat.checkSelfPermission(activity,permission)== PackageManager.PERMISSION_DENIED){
            return false;
        }
        return true;
    }

    public static void getPermission(Activity activity,String permission,int requestCode){
        if(!permissionIsOpen(activity,permission)){
            if(activity.shouldShowRequestPermissionRationale(permission)){
                showDialog(activity,permission,requestCode);
            }else{
                activity.requestPermissions(new String[]{permission},requestCode);
            }
        }
    }

    /**
     * 提示用户使用某个功能需要用到某权限的对话框
     */
    private static void showDialog(final Activity activity, final String permission, final int requestCode) {
        AlertDialog.Builder builder=new AlertDialog.Builder(activity);
        builder.setTitle("获取权限需要");
        builder.setMessage("拍照需要获取相机权限");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                activity.requestPermissions(new String[]{permission},requestCode);
            }
        });
        builder.setNegativeButton("取消",null);
        builder.show();
    }

}
