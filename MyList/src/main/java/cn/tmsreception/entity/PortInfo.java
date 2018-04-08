package cn.tmsreception.entity;

/**
 * Created by Happy on 2017-12-10.
 * 港口信息表
 */
public class PortInfo {
    private  String info_code;
    private String port;
    private int state;
    private String type;

    public String getInfo_code() {
        return info_code;
    }

    public void setInfo_code(String info_code) {
        this.info_code = info_code;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
