import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { CONSTANTS } from "../constants";
import { API_ENDPOINTS, WEB_ENDPOINTS } from "../endpoint";
import LoginForm from "../form/LoginForm";
import axios from 'axios';

const LoginPage = () => {
    const formInput = {
        name: "",
        password: ""
    };
    const navigate = useNavigate(); // 画面遷移用
    const [formdata, setFormdata] = useState(formInput);
    const [apiError, setApiError] = useState("");

    const updateFormdata = (e) => {
        const { name, value } = e.target;
        setFormdata({
            ...formdata,
            [name]: value
        });
    };

    // API呼び出し
    const handleLogin = async (e) => {
        e.preventDefault();
        try {
            const res = await axios.post(API_ENDPOINTS.LOGIN, formdata);
            if (res.data.result_code == CONSTANTS.SUCCESS) {
                navigate(WEB_ENDPOINTS.HOME);
            }
        } catch (err) {
            if (err.response) {
                if (err.response.status == CONSTANTS.VALIDATION_ERROR) {
                    setApiError(err.response.data.message);
                }
            } else if (err.request) {
                // リクエストは送信されたがレスポンスがなかった場合
                setApiError("サーバーとの通信に失敗しました。");
            } else {
                console.error(err);
            }
        }
    };

    return (
        <LoginForm
            formdata={formdata}
            updateFormdata={updateFormdata}
            apiError={apiError}
            handleLogin={handleLogin}
        />
    );
};

export default LoginPage;