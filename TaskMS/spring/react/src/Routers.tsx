import { BrowserRouter, Routes, Route } from 'react-router-dom';
import  Login  from "./pages/Login";
import { Page2 } from './pages/Page2';
import { Page1 } from './pages/Page1';
import  PrivateRouteMain  from './components/PrivateRouteMain';
import Main from './pages/Main';

function Routers(): JSX.Element {

    return (
        <div>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<Login />} />
                    <Route path="/auth" element={<PrivateRouteMain />} />
                    <Route path="/main" element={<Main />} >
                        <Route path="/main/page1" element={<Page1 />} />
                        <Route path="/main/page2" element={<Page2 />} />
                    </Route>
                </Routes>
            </BrowserRouter>
        </div>
    )
}

export default Routers
