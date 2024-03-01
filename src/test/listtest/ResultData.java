package test.listtest;
import java.util.List;
/**
 * @Author: Zhangdongdong
 * @Date: 2023/6/29 12:06
 */
public class ResultData {

    private String date;

    private List<ResultDataMealType> mealTypeList;
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public List<ResultDataMealType> getMealTypeList() {
        return mealTypeList;
    }
    public void setMealTypeList(List<ResultDataMealType> mealTypeList) {
        this.mealTypeList = mealTypeList;
    }
}

class ResultDataMealType {
    private String mid;

    public String getMid() {
        return mid;
    }
    public void setMid(String mid) {
        this.mid = mid;
    }
    public List<ResultDataDish> getDataDishList() {
        return dataDishList;
    }
    public void setDataDishList(List<ResultDataDish> dataDishList) {
        this.dataDishList = dataDishList;
    }
    private List<ResultDataDish> dataDishList;
}

class ResultDataDish {
    private String did;

    private String name;

    public String getDid() {
        return did;
    }
    public void setDid(String did) {
        this.did = did;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<ResultDataRelease> getResultDataReleaseList() {
        return resultDataReleaseList;
    }
    public void setResultDataReleaseList(List<ResultDataRelease> resultDataReleaseList) {
        this.resultDataReleaseList = resultDataReleaseList;
    }
    private List<ResultDataRelease> resultDataReleaseList;
}

class ResultDataRelease {
    private String rid;
    private String dName;
    private String url;
    private String price;
    private String status;
    public String getRid() {
        return rid;
    }
    public void setRid(String rid) {
        this.rid = rid;
    }
    public String getdName() {
        return dName;
    }
    public void setdName(String dName) {
        this.dName = dName;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
