package com.psj.user.mapper;

import com.psj.user.entity.po.SysUserPo;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/9-16:02
 * @description TODO
 */
public interface SysUserMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(SysUserPo record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(SysUserPo record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    SysUserPo selectByPrimaryKey(Long id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SysUserPo record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(SysUserPo record);
}