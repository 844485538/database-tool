import {HTTP_METHOD} from "../config/apiConfig";

import {reqHandle} from "../config/call";

export default {
    // 获取数据库连接
    dbInfo: reqHandle('/tool/info/db', {
        method: HTTP_METHOD.GET
    }),
    tableInfo: reqHandle('/tool/info/table', {
        method: HTTP_METHOD.GET
    }),
}
