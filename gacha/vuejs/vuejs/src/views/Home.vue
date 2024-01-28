<template>
    <div>
        <h1>ホーム</h1>
        <ul>
            <li>こちらはホーム画面です</li>
            <li>ガチャを引くためのアプリケーションです</li>
        </ul>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'Home',
    data() {
        return{

        }
    },
    mounted() {
        axios.get('http://localhost:8080/api/test', {
            headers: {
                "X-AUTH-TOKEN" : "Bearer " + this.$store.getters.getToken
            }
        })
        .then( res => {
            console.log("取得");
            console.log(res)
        })
        .catch(e => {
            alert("エラーが発生");
            console.log(e);
        })
    },
}
</script>
