import React, {Component} from 'react';
import { Link} from "react-router-dom";

class Header extends Component {
  render() {
    return (
        <div style= {{background: '#000033',height:'35px'}}>
            <Link class="btn btn-outline-primary" to="/" style= {{color:'#FFFFFF',fontSize:'15px'}}>商城</Link>
            <Link class="btn btn-outline-primary" to="/my-order" style= {{color:'#FFFFFF',fontSize:'15px'}}>订单</Link>
            <Link class="btn btn-outline-primary" to="/add-goods" style= {{color:'#FFFFFF',fontSize:'15px'}}>添加商品</Link>
         </div>  
    );
  }
}

export default Header;