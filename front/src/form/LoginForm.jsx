const LoginForm = ({
    formdata,
    updateFormdata,
    apiError,
    handleLogin
}) => {
    return (
        <form onSubmit={handleLogin}>
            <div>
                <h2>ログイン</h2>
                <div className="container">
                    {apiError && <p className="errorMessage">{apiError}</p>}
                    <div className="content">
                        <p>ユーザー名</p>
                        <input
                            className="textbox"
                            type="text"
                            name="name"
                            value={formdata.name}
                            onChange={updateFormdata}
                            maxLength={20}>
                        </input>
                    </div>
                    <div className="content">
                        <p>パスワード</p>
                        <input
                            className="textbox"
                            type="password"
                            name="password"
                            value={formdata.password}
                            onChange={updateFormdata}
                            inputMode="numeric"
                            maxLength={6}>
                        </input>
                    </div>
                    <div className="button">
                        <button 
                            type="submit" 
                            className="submit"
                            disabled = {formdata.name.trim() == "" || formdata.password.trim() == ""}>
                            ログイン
                        </button>
                    </div>
                </div>
            </div>
        </form>
    );
};

export default LoginForm;