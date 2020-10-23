import React, {Component} from 'react';


class AddGoods extends Component {
  state = {
    name:"",
    price:"",
    unit:"",
    img:""
  };

  stateChange = (field, event) =>{
    this.setState({
      [field]: event.target.value,
    });
  }

  handleSubmit(event){
    event.preventDefault();  
      
    const URL = 'http://localhost:8080///goods';
    var client = new XMLHttpRequest();
    client.open("POST", URL, false); 
    client.setRequestHeader("Content-Type", "text/plain;charset=UTF-8");
    client.send(this.statea);
      
  }

  formSubmit = (e) => {
    console.log(this.state);
  }
  render() {
    return (
      <div className="container" style= {{height: '600px'}}>
           <h1 style= {{textAlign: 'center'}}>添加商品</h1>
           <form className="my-form" >
              <div className="form-group">
                 <label htmlFor="name" style={{fontWeight: 'bold'}}>名称：</label>
                 <input
                   type="text"
                   value={this.state.name}
                   onChange={(e) => this.stateChange ("name",e)}
                   className="form-control"
                   placeholder="名称"
                   id="name"
                 />
              </div>
              <div className="form-group">
                  <label  htmlFor="price" style={{fontWeight: 'bold'}}>价格：</label>
                  <input
                   type="text"
                   value={this.state.price}
                   onChange={(e) => this.stateChange ("price",e)}
                   className="form-control"
                   placeholder="价格"
                   id="price"
                 />
              </div>
              <div className="form-group">
                  <label  htmlFor="unit" style={{fontWeight: 'bold'}}>单位：</label>
                  <input
                   type="text"
                   value={this.state.unit}
                   onChange={(e) => this.stateChange ("unit",e)}
                   className="form-control"
                   placeholder="单位"
                   id="unit"
                 />
              </div>
              <div className="form-group">
                  <label  htmlFor="img" style={{fontWeight: 'bold'}}>图片：</label>
                  <input
                   type="text"
                   value={this.state.img}
                   onChange={(e) => this.stateChange ("img",e)}
                   className="form-control"
                   placeholder="URL"
                   id="img"
                 />
              </div>
              <div className="form-group" >
                   <button type="submit" className="btn btn-primary" disabled={
                        this.state.name === "" ||
                        this.state.price === "" || 
                        this.state.unit === "" ||
                        this.state.img === "" 
                        } onClick={this.formSubmit()}>提交</button>
              </div>       
             </form>
      </div> 
    );
  }
}

export default AddGoods;