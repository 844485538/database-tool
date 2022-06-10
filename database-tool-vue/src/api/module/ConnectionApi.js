import {HTTP_METHOD} from "../config/apiConfig";

import {reqHandle} from "../config/call";

export default {
    // 获取数据库连接
    connection: reqHandle('/tool/connection', {
        method: HTTP_METHOD.POST
    }),
}
