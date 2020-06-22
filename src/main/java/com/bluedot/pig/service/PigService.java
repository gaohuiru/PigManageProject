package com.bluedot.pig.service;

import com.bluedot.framework.simplespring.core.annotation.Service;
import com.bluedot.framework.simplespring.inject.annotation.Autowired;
import com.bluedot.pig.mapper.BaseDao;
import com.bluedot.pig.mapper.BaseMapper;
import com.bluedot.pig.factory.MapperFactory;
import com.bluedot.pig.pojo.domain.PigInfo;
import com.bluedot.pig.service.base.BaseService;
import com.bluedot.pig.service.callback.ServiceCallback;

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

    @Autowired
    BaseDao baseDao;

    /**
     * 查询猪只数据列表
     * @param map 参数映射
     */
    private void queryPigs(Map<String,Object> map){
        doSimpleQueryListTemplate(map, new ServiceCallback<PigInfo>() {
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
        doRemoveByPrimaryKey(map, new ServiceCallback<PigInfo>() {
            @Override
            public List<PigInfo> doListExecutor(BaseMapper baseMapper, int pageStart, int pageSize) {
                return baseMapper.getPigs(pageStart,pageSize);
            }

            @Override
            public Long doCountExecutor(BaseMapper baseMapper) {
                return baseMapper.getPigsCount();
            }

            @Override
            public int doDataModifyExecutor(BaseMapper baseMapper) {
                String pigNo= (String) map.get("pigNo");
                PigInfo pigInfo=new PigInfo();
                pigInfo.setPigNo(pigNo);
                return baseDao.delete(pigInfo);
            }
        });
    }
}
