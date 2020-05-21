package com.slash.slashcast.home.rvHeader;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class RvHeaderRepo {

    private ArrayList<RvHeaderModel> headerList = new ArrayList<>();
    private MutableLiveData<List<RvHeaderModel>> mutableLiveData = new MutableLiveData<>();

    public RvHeaderRepo() {

    }

    MutableLiveData<List<RvHeaderModel>> getMutableLiveData() {
        RvHeaderModel model = new RvHeaderModel("https://source.unsplash.com/100x100/?startup",
                "How to develop our business model canvas" , "Behrooz Shahri" ,
                "https://source.unsplash.com/100x100/?man" , "12000");
        headerList.add(model);

        RvHeaderModel model1 = new RvHeaderModel("https://source.unsplash.com/100x100/?design",
                "Ux designer road map" , "Mahdi Deymi" ,
                "https://source.unsplash.com/100x100/?user" , "30000");
        headerList.add(model1);

        RvHeaderModel model2 = new RvHeaderModel("https://source.unsplash.com/100x100/?instagram",
                "Content strategy in instagram " , "Nazanin Fakhar" ,
                "https://source.unsplash.com/100x100/?social" , "5000");
        headerList.add(model2);

        mutableLiveData.setValue(headerList);
        return mutableLiveData;
    }
}
