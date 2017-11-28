# SaltedFish
## 咸鱼服务端 Springboot,Jpa


## API示例
# /saltedfish/api/message
## POST
| key           | value_type    |

| ------------- |:-------------:|

| nickName      | String        |

| content       | String        |

| diskLikeNum   | int           |

| likeNum       | int           |

### 返回json示例
'
{
    "code": 0,
    "msg": "成功",
    "data": {
        "id": 5,
        "nickName": "Airy",
        "content": "今天也要元气满满哦！",
        "likeNum": 99,
        "disLikeNum": null
    }
}
'
