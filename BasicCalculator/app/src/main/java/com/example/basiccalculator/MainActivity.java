package com.example.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
        String calculate(String answer) {
            int a = answer.indexOf("+");
            int s = answer.indexOf("-");
            int m = answer.indexOf("*");
            int d = answer.indexOf("/");
            int lB = answer.indexOf("(");
            int rB = answer.indexOf(")");
            int e = answer.indexOf("=");

            if (lB != -1 && rB != -1) {
                String bracketAnswer = answer.substring(lB + 1, rB) + "=";
                bracketAnswer=calculate(bracketAnswer);
                answer = answer.substring(0, lB) + (bracketAnswer) + answer.substring(rB + 1, e) + "=";
                return calculate(answer);
            }
            else if (m != -1 || d != -1) {
                String firstNumber = "";
                int leftBound =0;
                String secondNumber = "";
                int rightBound = 0;

                if (m < d) {
                    for (int i = (m - 1); i >= 0; i--) {
                        if (answer.charAt(i) == '+' || answer.charAt(i) == '-' || answer.charAt(i) == '*' || answer.charAt(i) == '/') {
                            firstNumber = new StringBuffer(firstNumber).reverse().toString();
                            leftBound = i+1;
                            break;
                        } else if (i == 0) {
                            firstNumber = firstNumber.concat(answer.substring(i, i + 1));
                            firstNumber = new StringBuffer(firstNumber).reverse().toString();
                            leftBound = 0;
                            break;
                        } else {
                            firstNumber = firstNumber.concat(answer.substring(i, i + 1));
                        }
                    }

                    for (int i = (m + 1); i <= e; i++) {
                        if (answer.charAt(i) == '+' || answer.charAt(i) == '-' || answer.charAt(i) == '*' || answer.charAt(i) == '/' || i == e) {
                            rightBound = i;
                            break;
                        } else {
                            secondNumber = secondNumber.concat(answer.substring(i, i + 1));
                        }
                    }

                    double mA = Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber);
                    String multipilcationAnswer = Double.toString(mA);
                    answer = answer.substring(0, leftBound) + multipilcationAnswer + answer.substring(rightBound, e) + "=";
                    return calculate(answer);
                }
                else
                {
                    for (int i = (d - 1); i >= 0; i--) {
                        if (answer.charAt(i) == '+' || answer.charAt(i) == '-' || answer.charAt(i) == '*' || answer.charAt(i) == '/') {
                            firstNumber = new StringBuffer(firstNumber).reverse().toString();
                            leftBound = i+1 ;
                            break;
                        } else if (i == 0) {
                            firstNumber = firstNumber.concat(answer.substring(i, i + 1));
                            firstNumber = new StringBuffer(firstNumber).reverse().toString();
                            leftBound = 0;
                            break;
                        } else {
                            firstNumber = firstNumber.concat(answer.substring(i, i + 1));
                        }
                    }

                    for (int i = (d + 1); i <= e; i++) {
                        if (answer.charAt(i) == '+' || answer.charAt(i) == '-' || answer.charAt(i) == '*' || answer.charAt(i) == '/'||i==e) {
                            rightBound = i;
                            break;
                        } else {
                            secondNumber = secondNumber.concat(answer.substring(i, i + 1));
                        }
                    }

                    double dA = Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber);
                    String divisionAnswer = Double.toString(dA);
                    answer = answer.substring(0, leftBound) + divisionAnswer + answer.substring(rightBound, e) + "=";
                    return calculate(answer);
                }
            }
            else if (a != -1 || s != -1) {
                String firstNumber = "";
                int leftBound = 0;
                String secondNumber = "";
                int rightBound = 0;

                if (a < s) {
                    for (int i = (a - 1); i >= 0; i--) {
                        if (answer.charAt(i) == '+' || answer.charAt(i) == '-' || answer.charAt(i) == '*' || answer.charAt(i) == '/') {
                            firstNumber = new StringBuffer(firstNumber).reverse().toString();
                            leftBound = i + 1;
                            break;
                        } else if (i == 0) {
                            firstNumber = firstNumber.concat(answer.substring(i, i + 1));
                            firstNumber = new StringBuffer(firstNumber).reverse().toString();
                            leftBound = 0;
                            break;
                        } else {
                            firstNumber = firstNumber.concat(answer.substring(i, i + 1));
                        }
                    }

                    for (int i = (a + 1); i <= e; i++) {
                        if (answer.charAt(i) == '+' || answer.charAt(i) == '-' || answer.charAt(i) == '*' || answer.charAt(i) == '/' || i == e) {
                            rightBound = i;
                            break;
                        } else {
                            secondNumber = secondNumber.concat(answer.substring(i, i + 1));
                        }
                    }
                    double aA = Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
                    String additionAnswer = Double.toString(aA);
                    answer = answer.substring(0, leftBound) + additionAnswer + answer.substring(rightBound, e) + "=";
                    return calculate(answer);
                }
                else {

                    for (int i = (s - 1); i >= 0; i--) {
                        if (answer.charAt(i) == '+' || answer.charAt(i) == '-' || answer.charAt(i) == '*' || answer.charAt(i) == '/') {
                            firstNumber = new StringBuffer(firstNumber).reverse().toString();
                            leftBound = i + 1;
                            break;
                        } else if (i == 0) {
                            firstNumber = firstNumber.concat(answer.substring(i, i + 1));
                            firstNumber = new StringBuffer(firstNumber).reverse().toString();
                            leftBound = 0;
                            break;
                        } else {
                            firstNumber = firstNumber.concat(answer.substring(i, i + 1));
                        }
                    }

                    for (int i = (s + 1); i <= e; i++) {
                        if (answer.charAt(i) == '+' || answer.charAt(i) == '-' || answer.charAt(i) == '*' || answer.charAt(i) == '/' || i == e) {
                            firstNumber = new StringBuffer(firstNumber).reverse().toString();
                            rightBound = i;
                            break;
                        } else {
                            secondNumber = secondNumber.concat(answer.substring(i, i + 1));
                        }
                    }

                    double sA = Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber);
                    String subtractionAnswer = Double.toString(sA);
                    answer = answer.substring(0, leftBound) + subtractionAnswer + answer.substring(rightBound, e) + "=";
                    return calculate(answer);
                }
            }
            else{
                answer=answer.substring(0,e);
                return answer;
            }
        }



        private
        Button button0;
        Button button1;
        Button button2;
        Button button3;
        Button button4;
        Button button5;
        Button button6;
        Button button7;
        Button button8;
        Button button9;
        Button add;
        Button subtract;
        Button multiply;
        Button divideBy;
        Button equal;
        Button clear;
        Button leftBracket;
        Button rightBracket;
        Button dot;
    public String answer="";

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.btn1);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);
                answer = answer.concat("1");
                textView.setText(answer);
            }
        });

        button2 = (Button) findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);
                answer = answer.concat("2");
                textView.setText(answer);
            }
        });

        button3 = (Button) findViewById(R.id.btn3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);
                answer = answer.concat("3");
                textView.setText(answer);
            }
        });

        button4 = (Button) findViewById(R.id.btn4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);
                answer = answer.concat("4");
                textView.setText(answer);
            }
        });

        button5 = (Button) findViewById(R.id.btn5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);
                answer = answer.concat("5");
                textView.setText(answer);
            }
        });

        button6 = (Button) findViewById(R.id.btn6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);
                answer = answer.concat("6");
                textView.setText(answer);
            }
        });

        button7 = (Button) findViewById(R.id.btn7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);
                answer = answer.concat("7");
                textView.setText(answer);
            }
        });

        button8 = (Button) findViewById(R.id.btn8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);
                answer = answer.concat("8");
                textView.setText(answer);
            }
        });

        button9 = (Button) findViewById(R.id.btn9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);
                answer = answer.concat("9");
                textView.setText(answer);
            }
        });

        button0 = (Button) findViewById(R.id.btn0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);
                answer = answer.concat("0");
                textView.setText(answer);
            }
        });

        add = (Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);
                answer = answer.concat("+");
                textView.setText(answer);
            }
        });


        subtract = (Button) findViewById(R.id.subtract);
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);
                answer = answer.concat("-");
                textView.setText(answer);
            }
        });

        multiply = (Button) findViewById(R.id.multiply);
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);
                answer = answer.concat("*");
                textView.setText(answer);
            }
        });

        divideBy = (Button) findViewById(R.id.divideBy);
        divideBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);
                answer = answer.concat("/");
                textView.setText(answer);
            }
        });

        leftBracket = (Button) findViewById(R.id.leftBracket);
        leftBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);
                answer = answer.concat("(");
                textView.setText(answer);
            }
        });

        rightBracket = (Button) findViewById(R.id.rightBracket);
        rightBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);
                answer = answer.concat(")");
                textView.setText(answer);
            }
        });

        clear = (Button) findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);
                answer = "";
                textView.setText("0");
            }
        });

        dot = (Button) findViewById(R.id.dot);
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);
                answer = answer.concat(".");
                textView.setText(answer);
            }
        });

        equal = (Button) findViewById(R.id.equal);
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView);
                answer = answer.concat("=");
                answer=calculate(answer);
                textView.setText(answer);

            };
        });


    }}