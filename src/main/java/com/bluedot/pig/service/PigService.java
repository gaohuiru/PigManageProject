package com.bluedot.pig.service;

import com.bluedot.framework.simplespring.core.annotation.Service;
import com.bluedot.framework.simplespring.inject.annotation.Autowired;
import com.bluedot.pig.mapper.BaseDao;
import com.bluedot.pig.mapper.BaseMapper;
import com.bluedot.pig.factory.MapperFactory;
import com.bluedot.pig.pojo.domain.PigInfo;
import com.bluedot.pig.service.base.BaseService;
import com.bluedot.pig.service.callback.ServiceCallback;
import com.bluedot.pig.util.TimeUtil;

import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * 猪只业务
 * @author xxbb
 */
@Service
public class PigService extends BaseService {
    @Autowired
    MapperFactory mapperFactory;



    /**
     * 查询猪只数据列表
     * @param map 参数映射
     */
    private void queryPigs(Map<String,Object> map){
        doSimpleQueryListTemplate(map, new ServiceCallback<PigInfo>() {
            @Override
            public List<PigInfo> doListExecutorByQueryCondition(BaseMapper baseMapper, int pageStart, int pageSize, String queryCondition, String queryValue) {
                return baseMapper.getPigsByQueryCondition(queryCondition, queryValue, pageStart,pageSize);
            }

            @Override
            public Long doCountExecutorByQueryCondition(BaseMapper baseMapper, String queryCondition, String queryValue) {
                return baseMapper.getPigsCountByQueryCondition(queryCondition,queryValue);
            }

            @Override
            public List<PigInfo> doListExecutor(BaseMapper baseMapper, int pageStart, int pageSize) {
                return baseMapper.getPigs(pageStart,pageSize);
            }

            @Override
            public Long doCountExecutor(BaseMapper baseMapper) {
                return baseMapper.getPigsCount();
            }
        });
    }

    /**
     * 删除猪只
     * @param map 参数映射
     */
    private void removePig(Map<String,Object> map){
        doSimpleModifyTemplate(map, new ServiceCallback<PigInfo>() {
            @Override
            public List<PigInfo> doListExecutorByQueryCondition(BaseMapper baseMapper, int pageStart, int pageSize, String queryCondition, String queryValue) {
                return baseMapper.getPigsByQueryCondition(queryCondition, queryValue, pageStart,pageSize);
            }

            @Override
            public Long doCountExecutorByQueryCondition(BaseMapper baseMapper, String queryCondition, String queryValue) {
                return baseMapper.getPigsCountByQueryCondition(queryCondition,queryValue);
            }

            @Override
            public List<PigInfo> doListExecutor(BaseMapper baseMapper, int pageStart, int pageSize) {
                return baseMapper.getPigs(pageStart,pageSize);
            }

            @Override
            public Long doCountExecutor(BaseMapper baseMapper) {
                return baseMapper.getPigsCount();
            }

            @Override
            public int doDataModifyExecutor(BaseDao baseDao) {
                String pigNo= (String) map.get("pigNo");
                PigInfo pigInfo=new PigInfo();
                pigInfo.setPigNo(pigNo);
                return baseDao.delete(pigInfo);
            }
        });
    }
    private void addPig(Map<String ,Object> map){
        doSimpleModifyTemplate(map, new ServiceCallback<PigInfo>() {
            @Override
            public List<PigInfo> doListExecutorByQueryCondition(BaseMapper baseMapper, int pageStart, int pageSize, String queryCondition, String queryValue) {
                return baseMapper.getPigsByQueryCondition(queryCondition, queryValue, pageStart,pageSize);
            }

            @Override
            public Long doCountExecutorByQueryCondition(BaseMapper baseMapper, String queryCondition, String queryValue) {
                return baseMapper.getPigsCountByQueryCondition(queryCondition,queryValue);
            }

            @Override
            public List<PigInfo> doListExecutor(BaseMapper baseMapper, int pageStart, int pageSize) {
                return baseMapper.getPigs(pageStart,pageSize);
            }

            @Override
            public Long doCountExecutor(BaseMapper baseMapper) {
                return baseMapper.getPigsCount();
            }

            @Override
            public int doDataModifyExecutor(BaseDao baseDao) {

                return baseDao.insert(packagingPigInfo(map));
            }
        });
    }
    private void modifyPig(Map<String,Object> map){
        doSimpleModifyTemplate(map, new ServiceCallback<PigInfo>() {
            @Override
            public List<PigInfo> doListExecutorByQueryCondition(BaseMapper baseMapper, int pageStart, int pageSize, String queryCondition, String queryValue) {
                return baseMapper.getPigsByQueryCondition(queryCondition, queryValue, pageStart,pageSize);
            }

            @Override
            public Long doCountExecutorByQueryCondition(BaseMapper baseMapper, String queryCondition, String queryValue) {
                return baseMapper.getPigsCountByQueryCondition(queryCondition,queryValue);
            }

            @Override
            public List<PigInfo> doListExecutor(BaseMapper baseMapper, int pageStart, int pageSize) {
                return baseMapper.getPigs(pageStart,pageSize);
            }

            @Override
            public Long doCountExecutor(BaseMapper baseMapper) {
                return baseMapper.getPigsCount();
            }

            @Override
            public int doDataModifyExecutor(BaseDao baseDao) {
                return baseDao.update(packagingPigInfo(map));
            }
        });
    }

    /**
     * 将map中的信息组合成PigInfo对象
     * @param map 数据集合
     * @return pigInfo
     */
    private PigInfo packagingPigInfo(Map<String,Object> map){
        String leaveDateStr="leaveDate";
        String pigNo= (String) map.get("pigNo");
        Integer sex= Integer.valueOf((String) map.get("sex"));
        Integer age= Integer.valueOf((String) map.get("age"));
        Integer pigVariety= Integer.valueOf((String) map.get("pigVarietyId"));
        Integer pigType=Integer.valueOf((String) map.get("pigType"));
        Integer pigState=Integer.valueOf((String) map.get("pigState"));
        Integer growthStage=Integer.valueOf((String) map.get("growthStage"));
        Date birthday= TimeUtil.parseToSqlDate((String)map.get("birthday")) ;
        Double pigRecentWeight=Double.valueOf((String)map.get("pigRecentWeight"));
        Integer vaccinumCount=Integer.valueOf((String) map.get("vaccinumCount"));
        Integer pigstyNo =Integer.valueOf((String) map.get("pigstyNo"));
        Integer hogcoteNo=Integer.valueOf((String) map.get("hogcoteNo"));
        Double pigBasicWeight=Double.valueOf((String)map.get("pigBasicWeight"));
        Date enterDate=TimeUtil.parseToSqlDate((String)map.get("enterDate"));
        Date leaveDate=null;
        String tempLeaveDate=(String)map.get("leaveDate");
        if(!tempLeaveDate.isEmpty()){
            leaveDate=TimeUtil.parseToSqlDate(tempLeaveDate);
        }
        return new PigInfo(pigNo,sex,age,pigVariety,pigType,pigState,
                growthStage,birthday,pigRecentWeight,vaccinumCount,pigstyNo,
                hogcoteNo,pigBasicWeight,enterDate,leaveDate);
    }
}
