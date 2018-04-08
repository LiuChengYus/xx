package cn.accp.service;

import cn.accp.entity.Options;
import cn.accp.entity.Subjects;

import java.util.List;

/**
 * @Auther: Xiao Yu
 * @Date: Created in 14:13 2018/3/12
 */
public interface ISubjectsService {
    public List<Subjects> selectSubjectList(Subjects subjects);
    public List<Options> selectOptionsList(Options options);
    //subjets
    public int updateSubjectsDate(Subjects subjects);

    //options
    public int updateOptionsDate(Options options);


    //look
    public int updateSubjectslook(Subjects subjects);

    //lookone
    public  Subjects selectOne(Integer id);
}
