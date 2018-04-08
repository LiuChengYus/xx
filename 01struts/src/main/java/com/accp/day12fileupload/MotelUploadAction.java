package com.accp.day12fileupload;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;

/**
 * Created by CY on 2018/3/1.
 */
public class UploadAction extends ActionSupport {

    private File upload;
    private String  uploadContextType;
    private String  uploadFileName;
    private  String  savePath="/upload";
    @Override
    public String execute() throws Exception {

        File destFile=new File(ServletActionContext.getRequest().getRealPath(savePath)+"//"+this.getUploadFileName());
        FileUtils.copyFile(upload,destFile);
        return SUCCESS;
    }
    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadContextType() {
        return uploadContextType;
    }

    public void setUploadContextType(String uploadContextType) {
        this.uploadContextType = uploadContextType;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
}
