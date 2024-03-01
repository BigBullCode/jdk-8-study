package test.listtest;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
/**
 * @Author: Zhangdongdong
 * @Date: 2023/6/29 11:40
 */
public class ListTest1 {

    public static void main(String[] args) {
        DemoData demoData;

        List<DemoData> dataList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        demoData = new DemoData();
                        demoData.setDate("2023-06-29" + i);
                        demoData.setMid("mid" + i + j);
                        demoData.settName("菜类名称" + i + j);
                        demoData.setDid("did" + i + j + k);
                        demoData.setRid("rid" + i + j + k + l);
                        demoData.setrName("菜名" + i + j + k + l);
                        demoData.setUrl("www.baidu.com");
                        demoData.setPrice("10");
                        demoData.setStatus("2");
                        dataList.add(demoData);
                    }
                }
            }
        }
        System.out.println(JSON.toJSONString(dataList));

        List<ResultData> resultDataList = new ArrayList<>();
//        dealData(dataList, resultDataList);
        aiDealData(dataList, resultDataList);

        System.out.println(JSON.toJSONString(resultDataList));
    }
    private static void aiDealData(List<DemoData> dataList, List<ResultData> resultDataList) {
        resultDataList.addAll(dataList.stream()
                .collect(Collectors.groupingBy(DemoData::getDate))
                .entrySet()
                .stream()
                .map(dateEntry -> {
                    ResultData resultData = new ResultData();
                    resultData.setDate(dateEntry.getKey());

                    List<ResultDataMealType> mealTypeList = dateEntry.getValue().stream()
                            .collect(Collectors.groupingBy(DemoData::getMid))
                            .entrySet()
                            .stream()
                            .map(mealEntry -> {
                                ResultDataMealType mealType = new ResultDataMealType();
                                mealType.setMid(mealEntry.getKey());

                                List<ResultDataDish> dishList = mealEntry.getValue().stream()
                                        .collect(Collectors.groupingBy(DemoData::getDid))
                                        .entrySet()
                                        .stream()
                                        .map(dishEntry -> {
                                            ResultDataDish dish = new ResultDataDish();
                                            dish.setDid(dishEntry.getKey());

                                            List<DemoData> filteredList = dataList.stream()
                                                    .filter(data -> dateEntry.getKey().equals(data.getDate()) &&
                                                            mealEntry.getKey().equals(data.getMid()) &&
                                                            dishEntry.getKey().equals(data.getDid()))
                                                    .collect(Collectors.toList());

                                            String tName = filteredList.get(0).gettName();
                                            dish.setName(tName);

                                            List<ResultDataRelease> releaseList = dishEntry.getValue().stream()
                                                    .map(data -> {
                                                        ResultDataRelease release = new ResultDataRelease();
                                                        release.setRid(data.getRid());
                                                        release.setdName(data.getrName());
                                                        release.setUrl(data.getUrl());
                                                        release.setPrice(data.getPrice());
                                                        release.setStatus(data.getStatus());
                                                        return release;
                                                    })
                                                    .collect(Collectors.toList());

                                            dish.setResultDataReleaseList(releaseList);
                                            return dish;
                                        })
                                        .collect(Collectors.toList());

                                mealType.setDataDishList(dishList);
                                return mealType;
                            })
                            .collect(Collectors.toList());

                    resultData.setMealTypeList(mealTypeList);
                    return resultData;
                })
                .collect(Collectors.toList()));
    }
    private static void dealData(List<DemoData> dataList, List<ResultData> resultDataList) {
        ResultData resultData;
        Map<String, List<DemoData>> collect = dataList.stream().collect(Collectors.groupingBy(DemoData::getDate));
        for (Map.Entry<String, List<DemoData>> dateEntry : collect.entrySet()) {
            resultData = new ResultData();
            resultData.setDate(dateEntry.getKey());
            List<ResultDataMealType> mealTypeList = new ArrayList<>();
            ResultDataMealType mealType;
            Map<String, List<DemoData>> collect1 = dateEntry.getValue().stream().collect(Collectors.groupingBy(DemoData::getMid));
            for (Map.Entry<String, List<DemoData>> mealEntry : collect1.entrySet()) {
                mealType = new ResultDataMealType();
                mealType.setMid(mealEntry.getKey());
                List<DemoData> value1 = mealEntry.getValue();
                Map<String, List<DemoData>> collect2 = value1.stream().collect(Collectors.groupingBy(DemoData::getDid));
                ResultDataDish dish;
                List<ResultDataDish> dishList = new ArrayList<>();
                for (Map.Entry<String, List<DemoData>> dishEntry : collect2.entrySet()) {
                    dish = new ResultDataDish();
                    dish.setDid(dishEntry.getKey());
                    List<DemoData> list = dataList.stream().filter(data -> dateEntry.getKey().equals(data.getDate()) && mealEntry.getKey().equals(data.getMid()) && dishEntry.getKey().equals(data.getDid())).collect(Collectors.toList());
                    String tName = list.get(0).gettName();
                    dish.setName(tName);
                    ResultDataRelease release;
                    List<ResultDataRelease> releaseList = new ArrayList<>();
                    for (DemoData data : dishEntry.getValue()) {
                        release = new ResultDataRelease();
                        release.setRid(data.getRid());
                        release.setdName(data.getrName());
                        release.setUrl(data.getUrl());
                        release.setPrice(data.getPrice());
                        release.setStatus(data.getStatus());
                        releaseList.add(release);
                    }
                    dish.setResultDataReleaseList(releaseList);
                    dishList.add(dish);
                }
                mealType.setDataDishList(dishList);
                mealTypeList.add(mealType);
            }
            resultData.setMealTypeList(mealTypeList);
            resultDataList.add(resultData);
        }
    }
}
