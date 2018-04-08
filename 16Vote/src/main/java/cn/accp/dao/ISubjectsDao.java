package cn.accp.dao;

import cn.accp.entity.Options;
import cn.accp.entity.Subjects;

import java.util.List;

/**
 * @Auther: Xiao Yu
 * @Date: Created in 14:12 2018/3/12
 */
public interface ISubjectsDao {
    public List<Subjects> selectSubjectList(Subjects subjects);
    public List<Options> selectOptionsList(Options options);

    //lookone
    public  Subjects selectOne(Integer id);
    //look
    public int updateSubjectslook(Subjects subjects);

    //subjets
    public int updateSubjectsDate(Subjects subjects);

    //options
    public int updateOptionsDate(Options options);
}
