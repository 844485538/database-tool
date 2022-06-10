import { HTTP_METHOD, DEFAULT_REQ_METHOD, URL_DEFAULT_PREFIX, IS_SERIALIZER_PARAMS } from './apiConfig'
import { paramsSerializer, isPlainObject } from './serializerConfig'
import axiosInstance from './axiosConfig'

export function getAxiosInstance () {
  return axiosInstance
}

export const AJAX = {
  get (url = '', params = {}, opts = {}) {
    return axiosInstance.get(url, {
      params,
      ...opts
    })
  },
  post (url = '', params = {}, opts = {}) {
    return axiosInstance.post(url, params, {
      ...opts
    })
  },
  put (url = '', params = {}, opts = {}) {
    return axiosInstance.put(url, params, {
      ...opts
    })
  },
  delete (url = '', params = {}, opts = {}) {
    // return axiosInstance.delete(url, {
    //   params,
    //   ...opts
    // })
    console.log('del---', params)
    let delConfig = {
      params,
      ...opts
    }
    if (params && params.data) { // 在delete方式下 需要将参数放入请求体中时：外层包一层data
      delConfig = {
        data: params.data,
        ...opts
      }
    }
    return axiosInstance.delete(url, delConfig)
  }
}

const defaultPrefix = URL_DEFAULT_PREFIX

/**
 * @param {String} path
 * @param {Object} opts
 * @prop {GET|POST} method - 请求类型
 * @prop {String} prefixer - url前缀
 * @prop {Boolean} isSerializerParams - 是否序列化提交数据
 */
export function reqHandle (
  path = '',
  { method = DEFAULT_REQ_METHOD, prefixer = defaultPrefix, isSerializerParams = IS_SERIALIZER_PARAMS, ...props } = {
    method: DEFAULT_REQ_METHOD,
    isSerializerParams: IS_SERIALIZER_PARAMS
  }
) {
  const reqPath = path.indexOf('/') === 0 ? path.slice(1) : path
  const reqUrl = /http(s)?:\/\//.test(reqPath) ? reqPath : `${prefixer}/${reqPath}`
  return params => {
    console.log('ajax', reqUrl, method, params)
    let reqParams = params
    if (isSerializerParams && method.toUpperCase() === HTTP_METHOD.POST && (isPlainObject(reqParams) || Array.isArray(reqParams))) {
      reqParams = paramsSerializer(reqParams)
    }
    return AJAX[method.toLowerCase()](reqUrl, reqParams, {
      ...props
    })
  }
}
