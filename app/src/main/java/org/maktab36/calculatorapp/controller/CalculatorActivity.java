package org.maktab36.calculatorapp.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.maktab36.calculatorapp.R;

public class CalculatorActivity extends AppCompatActivity {
    private static final String BUNDLE_KEY_TEXT_SHOW = "textViewShow";
    private TextView mTextViewShow;
    private Button mButtonDelete;
    private Button mButtonDivision;
    private Button mButtonSubtraction;
    private Button mButtonMultiplication;
    private Button mButtonAddition;
    private Button mButtonEqual;
    private Button mButtonZero;
    private Button mButtonOne;
    private Button mButtonTwo;
    private Button mButtonThree;
    private Button mButtonFour;
    private Button mButtonFive;
    private Button mButtonSix;
    private Button mButtonSeven;
    private Button mButtonEight;
    private Button mButtonNine;
    private Button mButtonDot;
    private boolean mFlag = false;
    private boolean mValidText = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        findAllViews();
        loadState(savedInstanceState);
        setListeners();
    }
    private void loadState(Bundle savedInstanceState){
        if(savedInstanceState!=null){
            mTextViewShow.setText(savedInstanceState.getCharSequence(BUNDLE_KEY_TEXT_SHOW));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence(BUNDLE_KEY_TEXT_SHOW,mTextViewShow.getText());
    }

    private void findAllViews() {
        mTextViewShow = findViewById(R.id.textViewShowNumbers);
        mButtonDelete = findViewById(R.id.buttonDelete);
        mButtonAddition = findViewById(R.id.buttonAddition);
        mButtonDivision = findViewById(R.id.buttonDivision);
        mButtonMultiplication = findViewById(R.id.buttonMultiplication);
        mButtonSubtraction = findViewById(R.id.buttonSubtraction);
        mButtonEqual = findViewById(R.id.buttonEqual);
        mButtonZero = findViewById(R.id.buttonZero);
        mButtonOne = findViewById(R.id.buttonOne);
        mButtonTwo = findViewById(R.id.buttonTwo);
        mButtonThree = findViewById(R.id.buttonThree);
        mButtonFour = findViewById(R.id.buttonFour);
        mButtonFive = findViewById(R.id.buttonFive);
        mButtonSix = findViewById(R.id.buttonSix);
        mButtonSeven = findViewById(R.id.buttonSeven);
        mButtonEight = findViewById(R.id.buttonEight);
        mButtonNine = findViewById(R.id.buttonNine);
        mButtonDot = findViewById(R.id.buttonDot);
    }

    private void setListeners() {
        mButtonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CalculatorActivity.this, R.string.button_equal,
                        Toast.LENGTH_SHORT).show();
                String input = mTextViewShow.getText().toString();
                mValidText = input.matches("(\\d*\\.?\\d+)(([+×\\-÷])(\\d*\\.?\\d+))*");
                if (mValidText) {
                    double result = calculate(mTextViewShow.getText().toString());
                    mFlag = true;
                    if (result - (int) result == 0) {
                        mTextViewShow.setText(String.valueOf((int) result));
                    } else {
                        mTextViewShow.setText(String.valueOf(result));
                    }
                } else {
                    Toast.makeText(CalculatorActivity.this,
                            R.string.toast_invalid_input, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CalculatorActivity.this, R.string.button_delete,
                        Toast.LENGTH_SHORT).show();
                StringBuilder temp = new StringBuilder(mTextViewShow.getText());
                temp.deleteCharAt(temp.length() - 1);
                mTextViewShow.setText(temp);
            }
        });

        mButtonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CalculatorActivity.this, R.string.button_division,
                        Toast.LENGTH_SHORT).show();
                mFlag = false;
                mTextViewShow.append("÷");
            }
        });

        mButtonAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CalculatorActivity.this, R.string.button_addition,
                        Toast.LENGTH_SHORT).show();
                mFlag = false;
                mTextViewShow.append("+");
            }
        });

        mButtonSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CalculatorActivity.this, R.string.button_subtraction,
                        Toast.LENGTH_SHORT).show();
                mFlag = false;
                mTextViewShow.append("-");

            }
        });

        mButtonMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CalculatorActivity.this, R.string.button_multiplication,
                        Toast.LENGTH_SHORT).show();
                mFlag = false;
                mTextViewShow.append("×");
            }
        });


        mButtonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CalculatorActivity.this, R.string.button_0,
                        Toast.LENGTH_SHORT).show();
                if (mFlag) {
                    mTextViewShow.setText(null);
                    mFlag = false;
                }
                mTextViewShow.append("0");

            }
        });

        mButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CalculatorActivity.this, R.string.button_1,
                        Toast.LENGTH_SHORT).show();
                if (mFlag) {
                    mTextViewShow.setText(null);
                    mFlag = false;
                }
                mTextViewShow.append("1");
            }
        });

        mButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CalculatorActivity.this, R.string.button_2,
                        Toast.LENGTH_SHORT).show();
                if (mFlag) {
                    mTextViewShow.setText(null);
                    mFlag = false;
                }
                mTextViewShow.append("2");
            }
        });

        mButtonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CalculatorActivity.this, R.string.button_3,
                        Toast.LENGTH_SHORT).show();
                if (mFlag) {
                    mTextViewShow.setText(null);
                    mFlag = false;
                }
                mTextViewShow.append("3");
            }
        });

        mButtonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CalculatorActivity.this, R.string.button_4,
                        Toast.LENGTH_SHORT).show();
                if (mFlag) {
                    mTextViewShow.setText(null);
                    mFlag = false;
                }
                mTextViewShow.append("4");
            }
        });

        mButtonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CalculatorActivity.this, R.string.button_5,
                        Toast.LENGTH_SHORT).show();
                if (mFlag) {
                    mTextViewShow.setText(null);
                    mFlag = false;
                }
                mTextViewShow.append("5");
            }
        });

        mButtonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CalculatorActivity.this, R.string.button_6,
                        Toast.LENGTH_SHORT).show();
                if (mFlag) {
                    mTextViewShow.setText(null);
                    mFlag = false;
                }
                mTextViewShow.append("6");
            }
        });

        mButtonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CalculatorActivity.this, R.string.button_7,
                        Toast.LENGTH_SHORT).show();
                if (mFlag) {
                    mTextViewShow.setText(null);
                    mFlag = false;
                }
                mTextViewShow.append("7");
            }
        });

        mButtonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CalculatorActivity.this, R.string.button_8,
                        Toast.LENGTH_SHORT).show();
                if (mFlag) {
                    mTextViewShow.setText(null);
                    mFlag = false;
                }
                mTextViewShow.append("8");
            }
        });

        mButtonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CalculatorActivity.this, R.string.button_9,
                        Toast.LENGTH_SHORT).show();
                if (mFlag) {
                    mTextViewShow.setText(null);
                    mFlag = false;
                }
                mTextViewShow.append("9");
            }
        });

        mButtonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CalculatorActivity.this, R.string.button_dot,
                        Toast.LENGTH_SHORT).show();
                if (mFlag) {
                    mTextViewShow.setText(null);
                    mFlag = false;
                }
                mTextViewShow.append(".");
            }
        });

    }

    private double calculate(String input) {
        String[] numbers = input.split("[-+÷×]");
        if (numbers.length == 1) {
            return Double.parseDouble(numbers[0]);
        }
        char operator = input.charAt(numbers[0].length());
        double num1 = Double.parseDouble(numbers[0]);
        double num2 = Double.parseDouble(numbers[1]);
        double result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '÷':
                result = num1 / num2;
                break;
            case '×':
                result = num1 * num2;
                break;
        }
        return result;
    }
}