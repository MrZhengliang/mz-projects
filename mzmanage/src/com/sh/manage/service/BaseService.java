/**
 * 
 */
package com.sh.manage.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sh.manage.exception.SPlatformServiceException;

/**
 * 其他service都继承此service，节俭了配置@Transactional
 * @author fuzl
 *
 */
@Service("baseService")
@Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = SPlatformServiceException.class)
public class BaseService {

}
