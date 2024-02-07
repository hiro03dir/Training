import useAuth from "../hooks/useAuth";
import { useLocation } from 'react-router-dom';

function PrivateRouteMain() {
  const { state } = useLocation();
  useAuth(state?.user, state?.pass);

  return null;
}

export default PrivateRouteMain;
