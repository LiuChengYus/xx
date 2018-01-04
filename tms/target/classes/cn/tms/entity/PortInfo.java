package cn.tms.entity;

/**
 * Created by CY on 2017/12/12.
 */
public class PortInfo {
    private String info_code;
    private String port;
    private String type;
    private Integer state;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
