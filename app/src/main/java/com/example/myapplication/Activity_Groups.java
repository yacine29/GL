package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class Activity_Groups extends AppCompatActivity {
    Button btn_ImportExcel_Group;
    //Intent Get Data Groups If Exsist
    private static ArrayList<Integer>groups=new ArrayList<>();
    private static ArrayList<String>names=new ArrayList<>();
    private static ArrayList<String>secondaryName=new ArrayList<>();
    private static final int PERMISSION_REQUEST_CODE = 1;
    private static final int PICK_FILE_REQUEST_CODE = 2;
    private static int index;
    private Promo promo;
    private void readExcelFile(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                Toast.makeText(this, "File not found!", Toast.LENGTH_SHORT).show();
                return;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            for (int i=0;i<=workbook.getNumberOfSheets()-1;i++){
                Sheet sheet = workbook.getSheetAt(i);
                for (Row row : sheet) {
                    for (Cell cell : row) {
                        switch (cell.getCellType()) {
                            case STRING:
                                if (cell.getStringCellValue().length()==8&&"GROUPE".equals(cell.getStringCellValue().substring(0,6).toString())){
                                    groups.add(Integer.parseInt(cell.getStringCellValue().substring(7,8)));//Change With Data Class Group
                                }
                                if (row.getRowNum()>=7){
                                    if (cell.getColumnIndex()==1){
                                        names.add(cell.getStringCellValue());//Change With Data Class Group
                                    }else if (cell.getColumnIndex()==2){
                                        secondaryName.add(cell.getStringCellValue());//Change With Data Class Group
                                    }
                                }
                                break;
                        }
                    }
                }
                //Do Somtihng About Split Groups
            }
            SystemSaveLoad systemSaveLoad = new SystemSaveLoad(getBaseContext());
            //#1
            //#2
            workbook.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error reading file!", Toast.LENGTH_SHORT).show();
        }
    }
    private void openFilePicker() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        try {
            startActivityForResult(Intent.createChooser(intent, "Select a File"), PICK_FILE_REQUEST_CODE);
        } catch (Exception e) {
            Toast.makeText(this, "No file picker found", Toast.LENGTH_SHORT).show();
        }
    }
    private String getFilePathFromUri(Uri uri) {
        String displayName = null;
        if ("content".equals(uri.getScheme())) {
            try (Cursor cursor = getContentResolver().query(uri, null, null, null, null)) {
                if (cursor != null && cursor.moveToFirst()) {
                    int displayNameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
                    if (displayNameIndex >= 0) {
                        displayName = cursor.getString(displayNameIndex);
                    }
                }
            }
        }
        if (displayName == null) {
            displayName = uri.getLastPathSegment();
        }
        String filePath = null;
        if ("content".equals(uri.getScheme())) {
            File file = new File(getFilesDir(), displayName);
            try (InputStream inputStream = getContentResolver().openInputStream(uri);
                 OutputStream outputStream = new FileOutputStream(file)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
                filePath = file.getPath();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("file".equals(uri.getScheme())) {
            filePath = uri.getPath();
        }
        return filePath;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        index=getIntent().getIntExtra("IndexPromo",0);
        promo = DataHolder.getInstance().getMyData().getPromos().get(index);
        Toast.makeText(this, "IN ActivityGroup "+promo.getNom(), Toast.LENGTH_SHORT).show();
        btn_ImportExcel_Group = findViewById(R.id.btn_ImportExcel_Group);
        btn_ImportExcel_Group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getBaseContext(), android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Activity_Groups.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                }else {
                    openFilePicker();
                }
            }
        });

        }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            } else {
                Toast.makeText(this, "Permission denied!", Toast.LENGTH_SHORT).show();
            }
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_FILE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            if (uri != null) {
                String filePath = getFilePathFromUri(uri);
                readExcelFile(filePath);
            }
        }
    }
}




