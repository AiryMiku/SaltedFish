# SaltedFish
## 咸鱼服务端 
* Springboot
* Jpa
* Redis
* A kind of socket util

## Todo
* 添加soket chat
* 完善逻辑

root:/saltedfish/api

## API示例

url:/message

method:POST

| key        | value_type |
| ---------- | ---------- |
| nickName   | String     |
| content    | String     |
| diskLikeNum| int        |
| likeNum    | int        |

返回json示例
```json
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
```
