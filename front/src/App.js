import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import { WEB_ENDPOINTS } from './endpoint';
import HomePage from './pages/HomePage';
import LoginPage from './pages/LoginPage';

const API_URL = "/Ingredient-Management";
function App() {
    return (
        <Router>
            <Routes>
                <Route
                    path = "/"
                    element = {<LoginPage/>}
                />
                <Route
                    path = {WEB_ENDPOINTS.HOME}
                    element = {<HomePage/>}
                />
                <Route
                    path = "*"
                    element = {<LoginPage/>}
                />
            </Routes>
        </Router>
    );
}

export default App;