package com.clever.common.service;

import com.clever.common.domain.AccessLog;
import com.clever.common.domain.Path;
import com.clever.common.service.base.IBaseService;
import com.clever.common.view.PaginationView;

import java.util.Collection;

/**
 * Info: clever
 * User: enva.liang@clever-m.com
 * Date: 2016-01-25
 * Time: 14:29
 * Version: 1.0
 * History: <p>如果有修改过程，请记录</P>
 */
public interface AccessLogManageService extends IBaseService {
    void listInPage(PaginationView paginationView);

    int count(PaginationView paginationView);

    @SuppressWarnings("rawtypes")
    Collection list(PaginationView paginationView);

    void addEntityBySeq(AccessLog a);

}
