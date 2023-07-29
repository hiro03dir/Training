<template>
    <div>
        <h1>ガチャ</h1>
        <button type="button" @click="play">ガチャを引く</button>
        <div><strong>{{error}}</strong></div>
        <ul>
            <li v-for="(character, index) in characters" :key="character.id">
                {{index+1}}:{{character.name}}
            </li>
        </ul>
    </div>
</template>
<script>
import axios from 'axios'

export default {
    name: 'Gacha',
    data() {
        return{
            characters: [],
            error: "",
        }
    },
    methods: {
        play(){
            console.log("ガチャボタンが押されました。")
            axios.post('http://localhost:8080/api/playgacha',{},{
                headers: {
                    "X-AUTH-TOKEN" : "Bearer " + this.$store.getters.getToken
                }
            })
            .then(res => {
                if("message" in res.data){
                    console.log("coinが足りません。")
                    this.error = res.data.message
                }else {
                    this.error = ""
                    console.log("ガチャが引かれました。")
                    this.characters = res.data
                }
            })
            .catch(e => {
                alert("エラーが発生")
                console.log(e)
            })
        },
    },
    mounted() {
        axios.get('http://localhost:8080/api/islogin', {
            headers : {
                "X-AUTH-TOKEN": "Bearer " + this.$store.getters.getToken
            }
        })
        .then(res => {
            console.log(res)
        })
        .catch( () => {
            alert("ログインしてください")
            this.$router.push("/login")
        })
    },
}
</script>
