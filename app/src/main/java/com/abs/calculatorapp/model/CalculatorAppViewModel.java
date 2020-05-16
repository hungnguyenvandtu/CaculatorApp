package com.abs.calculatorapp.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalculatorAppViewModel extends ViewModel {
    private MutableLiveData<StringBuilder> expression = new MutableLiveData<>();

    public MutableLiveData<StringBuilder> getExpression() {
        return expression;
    }

}
