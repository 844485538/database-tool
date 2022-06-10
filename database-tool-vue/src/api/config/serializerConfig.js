/* eslint-disable no-useless-escape */
import qs from 'qs'

const toString = Object.prototype.toString

export function logoutNotice () {
  // 弹窗
}

export function downloadUrl (url) {
  const iframe = document.createElement('iframe')
  iframe.style.display = 'none'
  iframe.src = url
  document.body.appendChild(iframe)
  iframe.onload = function () {
    setTimeout(() => {
      document.body.removeChild(iframe)
    })
  }
}
// eslint-disable-next-line no-unused-vars
function blobify (s) {
  const buf = new ArrayBuffer(s.length)
  const view = new Uint8Array(buf)
  // eslint-disable-next-line no-bitwise
  for (let i = 0; i !== s.length; ++i) view[i] = s.charCodeAt(i) & 0xff
  return buf
}
function getFileName (disposition) {
  // debugger
  let filename = ''
  if (disposition && disposition.indexOf('attachment') !== -1) {
    // const pattern = /\"(.*)\"/
    // const matches = disposition.match(pattern)
    // if (matches != null && matches[1]) {
    //   filename = matches[1].replace(/['"]/g, '')
    //   return filename
    // }
    const filenameRegex = /filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/
    const matches = filenameRegex.exec(disposition)
    if (matches != null && matches[1]) {
      filename = matches[1].replace(/['"]/g, '')
    }
  }
  return filename
}
export function downloadBlob (res) {
  try {
    // const contentType = 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8';
    const blob = new Blob([res.data], { type: 'application/vnd.ms-excel' })
    // const blob = new Blob([blobify(res.data)]);
    // const blob = new Blob([res.data], { type: contentType });
    // const blob = new Blob([blobify(res.data)], { type: '' });
    // const blob = new Blob([res.data])
    console.log('content-disposition---', res.headers['content-disposition'])
    let fileName = getFileName(res.headers['content-disposition'])
    // 判断是否是乱码
    if (escape(fileName).indexOf('%') > -1 && escape(fileName).indexOf('%u') < 0) {
      fileName = decodeURIComponent(escape(fileName))
    } else {
      fileName = decodeURIComponent(fileName)
    }
    console.log('file-name--', fileName)
    if (navigator.msSaveOrOpenBlob) {
      navigator.msSaveOrOpenBlob(blob, fileName)
    } else {
      const link = document.createElement('a')
      const blobUrl = URL.createObjectURL(blob)
      console.log('---blobUrl---', blobUrl)
      link.href = blobUrl
      link.download = fileName
      document.body.appendChild(link)
      link.click()
      document.body.removeChild(link)
      URL.revokeObjectURL(blobUrl) // 释放掉blob对象
    }
    return {
      code: 10000,
      message: '下载成功'
    }
  } catch (error) {
    console.log(error)
    return {
      code: '500',
      error: error,
      message: error.message || '下载失败'
    }
  }
}

export function paramsSerializer (params = {}) {
  return qs.stringify(params, {
    arrayFormat: 'brackets'
  })
}

export function isPlainObject (obj) {
  return toString.call(obj) === '[object Object]'
}
