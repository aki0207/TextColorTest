package com.example.textcolortest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtFirst, mBtSecond, mBtThird,mMove;

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPreferences = getSharedPreferences("themeData", MODE_PRIVATE);
        setTheme( mPreferences.getInt("theme", R.style.FirstTheme) );
        setContentView(R.layout.activity_main);

        mBtFirst  = (Button)findViewById(R.id.bt_first);
        mBtSecond = (Button)findViewById(R.id.bt_second);
        mBtThird  = (Button)findViewById(R.id.bt_third);
        mMove = (Button)findViewById(R.id.move);

        mBtFirst.setOnClickListener(this);
        mBtSecond.setOnClickListener(this);
        mBtThird.setOnClickListener(this);
        mMove.setOnClickListener(this);

        mEditor = mPreferences.edit();
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.bt_first: {
                mEditor.putInt("theme", R.style.FirstTheme);
                break;
            }
            case R.id.bt_second: {
                mEditor.putInt("theme", R.style.SecondTheme);
                break;
            }
            case R.id.bt_third: {
                mEditor.putInt("theme", R.style.ThirdTheme);
                break;
            }
            case R.id.move: {
                Intent intent = new Intent(getApplication(),SubActivity.class);
                startActivity(intent);
                return;

            }
        }
        mEditor.commit();
        finish();
        startActivity( new Intent( this, MainActivity.class ));
    }
}