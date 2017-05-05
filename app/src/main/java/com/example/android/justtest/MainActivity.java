package com.example.android.justtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 100;//测试的总分数,初始化100分

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 提交测验的方法
     * @param view
     */
    public void submitTest(View view) {
        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.rg1);
        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.rg2);
        RadioButton rb3rg1 = (RadioButton) findViewById(R.id.rb3_rg1);
        RadioButton rb2rg2 = (RadioButton) findViewById(R.id.rb2_rg2);
        Integer rd1CheckedId = radioGroup1.getCheckedRadioButtonId();
        Integer rd2CheckedId = radioGroup2.getCheckedRadioButtonId();
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.juzi_isBelongSNK_checkbox);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.huowu_isBelongSNK_checkbox);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.xiaoqiao_isBelongSNK_checkbox);
        EditText mostExpHero = (EditText) findViewById(R.id.mostExpensiveHero_editText);
        String mostExpHeroTest = mostExpHero.getText().toString();
        EditText advise = (EditText) findViewById(R.id.advise_editText);
        //判断用户填报的选项是否正确,错误的每项扣25分.
        if (rd1CheckedId != null && rd2CheckedId != null && mostExpHeroTest != null && !"".equals(mostExpHeroTest)
                && (checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked())) {
            if(rd1CheckedId!=rb3rg1.getId()){
                score -= 25;
            }
            if(rd2CheckedId!=rb2rg2.getId()){
                score -= 25;
            }
            if(!(checkBox1.isChecked()&&checkBox2.isChecked())){
                score -= 25;
            }
            if(!"武则天".equals(mostExpHeroTest.trim())){
                score -= 25;
            }
            LinearLayout editLayout = (LinearLayout) findViewById(R.id.edit_layout);
            LinearLayout resultLayout= (LinearLayout) findViewById(R.id.result_layout);
            TextView scoreTextView = (TextView) findViewById(R.id.score_view);
            //设置填报页面隐藏,结果页面显示
            editLayout.setVisibility(View.GONE);
            resultLayout.setVisibility(View.VISIBLE);
            scoreTextView.setText(""+score);

        }else{
            Toast.makeText(this,"请先完成测验!",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 再次测验的方法
     * @param view
     */
    public void reTest(View view){
        score = 100;
        LinearLayout editLayout = (LinearLayout) findViewById(R.id.edit_layout);
        LinearLayout resultLayout= (LinearLayout) findViewById(R.id.result_layout);
        //设置填报页面显示,结果页面隐藏
        editLayout.setVisibility(View.VISIBLE);
        resultLayout.setVisibility(View.GONE);
        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.rg1);
        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.rg2);
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.juzi_isBelongSNK_checkbox);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.huowu_isBelongSNK_checkbox);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.xiaoqiao_isBelongSNK_checkbox);
        //清空填报页面的控件的checked属性以及editText中的文字
        radioGroup1.clearCheck();
        radioGroup2.clearCheck();
        checkBox1.setChecked(false);
        checkBox2.setChecked(false);
        checkBox3.setChecked(false);
        EditText mostExpHero = (EditText) findViewById(R.id.mostExpensiveHero_editText);
        mostExpHero.setText("");
        EditText advise = (EditText) findViewById(R.id.advise_editText);
        advise.setText("");
    }
}
