import { Outlet } from 'react-router-dom';
import Header from "../components/Header";

function Main(): JSX.Element {
  return (
    <div>
        <Header />
        <Outlet />
    </div>
  );
}

export default Main
