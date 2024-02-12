import { useState, useEffect } from "react";
import { getAuth } from "../api/auth";
import { useNavigate } from 'react-router-dom';

function useAuth(user: string, pass: string): number | undefined {
	const navigate = useNavigate();
	const [status,setStatus] = useState<number>();
	useEffect(() => {
		getAuth(user, pass).then((res) => {
			setStatus(res.status);
			navigate('/main')
		}).catch((err) => {
			setStatus(err.response.status);
			navigate('/');
		});
	}, []);
	return status;
}

export default useAuth
