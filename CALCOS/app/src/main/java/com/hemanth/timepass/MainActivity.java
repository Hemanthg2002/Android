package com.hemanth.timepass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity{
    private EditText Scr;// textbox screen
    private EditText Scr2;
    private float NumberBF;// save screen before button operation
    private String NumUP;
    private String operation = "";
   // private ButtonClickListener btnClick;
    private String numb;
    private String Current="0";
    int check=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // create manager instance after the content view is set
      //  SystemBarTintManager mTintManager = new SystemBarTintManager(this);
// enable status bar tint
       // mTintManager.setStatusBarTintEnabled(true);
        //mTintManager.setTintColor(getResources().getColor(R.color.background_material_light));


        Scr = (EditText) findViewById(R.id.editText);
        Scr.setEnabled(false);

        Scr2 = (EditText) findViewById(R.id.editText2);
        Scr2.setEnabled(false);

        /*int idList[] = {R.id.imageButton0,R.id.imageButton1,R.id.imageButton2,R.id.imageButton3,
                R.id.imageButton4,R.id.imageButton5,R.id.imageButton6,R.id.imageButton7,
                R.id.imageButton8,R.id.imageButton9,R.id.imageButtondot,R.id.imageButtonequ,
                R.id.imageButtonmul,R.id.imageButtonadd,R.id.imageButtonsub,R.id.imageButtondiv,
        R.id.button1,R.id.button2,R.id.imageButtonclr};*/

       /* for(int id:idList){
            View v =(View) findViewById(id);
            v.setOnClickListener(btnClick);

        }*/
    }

    //@Override
   // public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
     //   getMenuInflater().inflate(R.menu.menu_main, menu);
      //  return true;
  //  }

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/


    public void clear(View view){
        Scr.setText("0");
        Scr2.setText("");
        NumberBF = 0;
        NumUP="";
        Current="0";
        operation="";
        check=0;
    }

    public void add(View view){
        mMath("+");
    }


    public void sub(View view){
        mMath("-");
    }

    public void mul(View view){
        mMath("x");
    }


    public void div(View view){
        mMath("/");
    }


    public void equ(View view){
        mResult();
    }


    public void zero(View view){
        numb="0";
        getKeyboard(numb);

    }

    public void one(View view){
        numb="1";
        getKeyboard(numb);

    }

    public void two(View view){
        numb="2";
        getKeyboard(numb);

    }

    public void three(View view){
        numb="3";
        getKeyboard(numb);

    }

    public void four(View view){
        numb="4";
        getKeyboard(numb);

    }

    public void five(View view){
        numb="5";
        getKeyboard(numb);

    }

    public void six(View view){
        numb="6";
        getKeyboard(numb);

    }

    public void seven(View view){
        numb="7";
        getKeyboard(numb);

    }

    public void eight(View view){
        numb="8";
        getKeyboard(numb);

    }

    public void nine(View view){
        numb="9";
        getKeyboard(numb);

    }


    public void dot(View view){
        numb=".";
        getKeyboard(numb);

    }



/*public void default(){
        String num = ((Button) v).getText().toString();
        getKeyboard(num);

    }*/


    public void mMath(String s){
    NumberBF=Float.parseFloat(Scr.getText().toString());
    operation=s;
        Scr.setText("0");
        Scr2.setText(NumberBF+operation);


    }

    public void getKeyboard(String s){
     String ScrCurrent = Scr.getText().toString();
        if(ScrCurrent.equals("0"))

            ScrCurrent="";

        ScrCurrent+=s;
        Scr.setText(ScrCurrent);
        Current=ScrCurrent;


    }

    public void mResult(){
        float NumAF= Float.parseFloat(Scr.getText().toString());
        float result = 0;
        check=0;

        NumUP=Scr2.getText().toString();
        Scr2.setText(NumUP+NumAF);

        if(operation.equals("+")){
            result=NumAF+NumberBF;
        }
        if(operation.equals("x")){
            result=NumAF*NumberBF;
        }
        if(operation.equals("-")){
            result=NumberBF-NumAF;
        }
        if(operation.equals("/")){
            result=NumberBF/NumAF;
        }
        if(operation.equals("")){
            if(Current.equals("0")) {
                Scr.setText("0");
                check = 1;
            }
            else
            result=Float.parseFloat(Current);
        }

        if(check==1) {

        }
        else
        Scr.setText(String.valueOf(result));
    }


  /*  private class ButtonClickListener implements View.OnClickListener{


        public void onClick(View v){
            String numb;
            switch (v.getId()){

                case R.id.imageButtonclr:
                    Scr.setText("0");
                    NumberBF = 0;
                    operation="";
                    break;
                case R.id.imageButtonadd:
                    mMath("+");
                    break;
                case R.id.imageButtonsub:
                    mMath("-");
                    break;
                case R.id.imageButtonmul:
                    mMath("*");
                    break;
                case R.id.imageButtondiv:
                    mMath("/");
                    break;
                case R.id.imageButtonequ:
                    mResult();
                    break;
                case R.id.imageButton0:
                    numb="0";
                    getKeyboard(numb);
                    break;
                case R.id.imageButton1:
                    numb="1";
                    getKeyboard(numb);
                    break;
                case R.id.imageButton2:
                    numb="2";
                    getKeyboard(numb);
                    break;
                case R.id.imageButton3:
                    numb="3";
                    getKeyboard(numb);
                    break;
                case R.id.imageButton4:
                    numb="4";
                    getKeyboard(numb);
                    break;
                case R.id.imageButton5:
                    numb="5";
                    getKeyboard(numb);
                    break;
                case R.id.imageButton6:
                    numb="6";
                    getKeyboard(numb);
                    break;
                case R.id.imageButton7:
                    numb="7";
                    getKeyboard(numb);
                    break;
                case R.id.imageButton8:
                    numb="8";
                    getKeyboard(numb);
                    break;
                case R.id.imageButton9:
                    numb="9";
                    getKeyboard(numb);
                    break;
                case R.id.imageButtondot:
                    numb=".";
                    getKeyboard(numb);
                    break;
                default:
                    String num =((Button) v).getText().toString();
                    getKeyboard(num);
                    break;









            }

        }
    }*/




}
