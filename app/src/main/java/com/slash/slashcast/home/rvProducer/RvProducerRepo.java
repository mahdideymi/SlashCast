package com.slash.slashcast.home.rvProducer;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class RvProducerRepo {

    private ArrayList<RvProducerModel> producerList = new ArrayList<>();
    private MutableLiveData<List<RvProducerModel>> mutableLiveData = new MutableLiveData<>();

    public MutableLiveData<List<RvProducerModel>> getMutableLiveData() {
        RvProducerModel model = new RvProducerModel(
                "https://source.unsplash.com/100x100/?Man" , "Rassol"
        );

        RvProducerModel model1 = new RvProducerModel(
                "https://source.unsplash.com/100x100/?woman" , "Negar"
        );

        RvProducerModel model2 = new RvProducerModel(
                "https://source.unsplash.com/100x100/?child" , "Mahdi"
        );

        RvProducerModel model3 = new RvProducerModel(
                "https://source.unsplash.com/100x100/?father" , "Behrooz"
        );

        RvProducerModel model4 = new RvProducerModel(
                "https://source.unsplash.com/100x100/?mother" , "Nazanin"
        );

        RvProducerModel model6 = new RvProducerModel(
                "https://source.unsplash.com/100x100/?brother" , "Meysam"
        );

        RvProducerModel model7 = new RvProducerModel(
                "https://source.unsplash.com/100x100/?sister" , "Zahra"
        );

        producerList.add(model);
        producerList.add(model1);
        producerList.add(model2);
        producerList.add(model3);
        producerList.add(model4);
        producerList.add(model6);
        producerList.add(model7);

        mutableLiveData.setValue(producerList);

        return mutableLiveData;
    }
}
