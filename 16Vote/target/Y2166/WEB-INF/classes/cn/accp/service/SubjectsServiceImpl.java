package cn.accp.service;

import cn.accp.dao.ISubjectsDao;
import cn.accp.entity.Options;
import cn.accp.entity.Subjects;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: Xiao Yu
 * @Date: Created in 14:14 2018/3/12
 */
@Service("iSubjectsService")
public class SubjectsServiceImpl implements ISubjectsService {
    @Resource(name = "ISubjectsDao")
    private ISubjectsDao subjectsDao;
    public List<Subjects> selectSubjectList(Subjects subjects){
        return subjectsDao.selectSubjectList(subjects);
    }

    public List<Options> selectOptionsList(Options options) {
        return subjectsDao.selectOptionsList(options);
    }

    public int updateSubjectsDate(Subjects subjects) {
        return subjectsDao.updateSubjectsDate(subjects);
    }

    public int updateOptionsDate(Options options) {
        return subjectsDao.updateOptionsDate(options);
    }

    public int updateSubjectslook(Subjects subjects) {
        return subjectsDao.updateSubjectslook(subjects);
    }

    public Subjects selectOne(Integer id) {
        return subjectsDao.selectOne(id);
    }
}
