package com.finalpj.backend.util;

import java.util.ArrayList;

import lombok.Data;

@Data
//처음부터 담을 타입을 설정할수있도록 클래스를 설계
public class OneGate<T> {

    //필요할 데이터를 담을 리스트에도 제네릭 선언
    private ArrayList<T> list;
    private PageVO pageVO;


    public OneGate() {
        super();
    }

    public OneGate(ArrayList<T> list, PageVO pageVO){
        this.list = list;
        this.pageVO = pageVO;
    }

}
