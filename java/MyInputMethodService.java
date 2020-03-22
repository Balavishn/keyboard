package com.example.balavishnu.coderkey;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;


public class MyInputMethodService extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    KeyboardView keyboardView;
    Keyboard keyboard;
    boolean isCaps=false;

    @Override
    public View onCreateInputView() {
        keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
        keyboard = new Keyboard(this, R.xml.number_pad);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        return keyboardView;
    }

    @Override
    public void onPress(int i) {

    }

    @Override
    public void onRelease(int i) {

    }

    @Override
    public void onKey(int i, int[] inits) {
        InputConnection ic = getCurrentInputConnection();
        if(i==9001){
            ic=getCurrentInputConnection();
            keyboard=new Keyboard(this,R.xml.code);
            keyboardView.setKeyboard(keyboard);
            keyboardView.setOnKeyboardActionListener(this);
            isCaps = false;
            keyboard.setShifted(isCaps);
        }
        else if(i==9000){
            ic=getCurrentInputConnection();
            keyboard=new Keyboard(this,R.xml.number_pad);
            keyboardView.setKeyboard(keyboard);
            keyboardView.setOnKeyboardActionListener(this);

        }
        else if(i==8999){
            ic=getCurrentInputConnection();
            keyboard=new Keyboard(this,R.xml.special_char);
            keyboardView.setKeyboard(keyboard);
            keyboardView.setOnKeyboardActionListener(this);
            isCaps = false;
            keyboard.setShifted(isCaps);
        }
        switch (i)
        {
            case 9000:break;
            case 9001:break;
            case 8999:break;
            case Keyboard.KEYCODE_DELETE:
                ic.deleteSurroundingText(1,0);
                break;
            case Keyboard.KEYCODE_SHIFT:
                isCaps = !isCaps;
               keyboard.setShifted(isCaps);
               keyboardView.invalidateAllKeys();
                break;
            case Keyboard.KEYCODE_DONE:
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN,KeyEvent.KEYCODE_ENTER));
                break;
            case 1000:
                ic.commitText("if(",1);
                ic.commitText(")",0);
                ic.commitText("",-1);
                break;
            case 1001:
                ic.commitText("else(",1);
                ic.commitText(")",0);
                ic.commitText("",-1);
                break;
            case 1002:
                ic.commitText("else if(",1);
                ic.commitText(")",0);
                ic.commitText("",-1);
                break;
            case 1003:
                ic.commitText("switch",1);
                break;
            case 1004:
                ic.commitText("case ",1);
                break;
            case 1005:
                ic.commitText("(",1);
                ic.commitText(")",0);
                ic.commitText("",-1);
                break;
            case 1006:
                ic.commitText("{",1);
                ic.commitText("}",0);
                ic.commitText("",-1);
                break;
            case 1007:
                ic.commitText("[",1);
                ic.commitText("]",0);
                ic.commitText("",-1);
                break;
            case 1008:
                ic.commitText("for",1);
                break;
            case 1009:
                ic.commitText("do{}while()",1);
                break;
            case 1010:
                ic.commitText("while(",1);
                ic.commitText(")",0);
                ic.commitText("",-1);
                break;
            case 1011:
                ic.commitText("void",1);
                break;
            case 1012:
                ic.commitText("int",1);
                break;
            case 1013:
                ic.commitText("char",1);
                break;
            case 1014:
                ic.commitText("float",1);
                break;
            case 1015:
                ic.commitText("long",1);
                break;
            case 1016:
                ic.commitText("String",1);
                break;
            case 1017:
                ic.commitText("double",1);
                break;
            case 1018:
                ic.commitText("//",1);
                break;
            case 1019:
                ic.commitText("||",1);
                break;
            case 1020:
                ic.commitText("",-1);
                break;
            case 1021:
                ic.commitText("",2);
                break;
            default:
                char code = (char)i;
                if(Character.isLetter(code) && isCaps)
                    code = Character.toUpperCase(code);
                ic.commitText(String.valueOf(code),1);
        }
    }

    @Override
    public void onText(CharSequence charSequence) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }
}
