import axios from "axios";

const authorizationURL = "/api/auth";
export const getAuth =  async(user:string,pass:string) => {
	const response = await axios.get(authorizationURL,{
		auth: {username:user,password:pass}
	});
	return response;
}
