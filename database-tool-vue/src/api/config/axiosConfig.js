import axios from 'axios'
import { ElMessage  } from 'element-plus'
import { REQ_TIME_OUT } from './apiConfig'
import { paramsSerializer } from './serializerConfig'
import { downloadBlob } from './utils'
//import router from '@/router';

const axiosConfig = {
  paramsSerializer,
  timeout: REQ_TIME_OUT,
  baseURL: '',
  headers: {
    'X-Requested-With': 'XMLHttpRequest'
  }
}
const axiosInstance = axios.create(axiosConfig)

// 请求拦截器
axiosInstance.interceptors.request.use((config) => {
  return config;
})

// 响应拦截器
axiosInstance.interceptors.response.use(response =>
    {
      const contentDisposition = response.headers['content-disposition']
      if (response.status === 200 && response.data.code === 6200){
        // axios在处理接口返回值时，默认会自动给包裹一个data字段
        return response.data;
      } else if (response.data.code === 6500) {
        ElMessage.error(response.data.message);
        return Promise.reject(new Error(response.data.message))
      } else if (contentDisposition && response.headers['content-disposition'].split(';')[0] === 'attachment') {
        // console.log('res--', res);
        // downloadUrl(res.request.responseURL);
        downloadBlob(response)
      } else {
        ElMessage.error("接口调用错误");
        return Promise.reject(new Error("接口调用错误"))
      }
    }, error => {
      ElMessage.error(error.message);
      return Promise.reject(error)
    }
)

// 最终需要对外暴露（不对外暴露外面模块没办法使用）
// 这里的代码是暴露一个axios实例
export default axiosInstance;
