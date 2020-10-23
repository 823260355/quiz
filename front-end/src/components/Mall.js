import React, {Component} from 'react';
import axios from 'axios';
import { Popover, Button, Table, Space, InputNumber } from 'antd';
import './index.css';
  
  class Mall extends Component {
    state = {
      goods: [],
      goodsOrder: [{
        id: 1,
        name: '可乐',
        amount: 3
      }]
    };
  
    componentDidMount() {
      axios.get("http://localhost:8080/goods").then(res => {
        const goods = res.data;
        this.setState({
          goods
        });
      });
    }
  
    createOrder = () => {
      axios.post("http://localhost:8080/orders", {'order': this.state.goodsOrder}).then(res => {
        if (res.status === 200) alert('添加成功');
      })
    }
  
    addGoods = (goods) => {
      const goodsOrder = this.state.goodsOrder;
      let tag = false;
      goodsOrder.map((goodsOrder) => {
        if (goodsOrder.id === goods.id) {
          goodsOrder.amount +=1;
          tag = true;
        }
        return goodsOrder;
      });
      if (tag === false) goodsOrder.push({
          id: goods.id,
          name: goods.name,
          amount: 1,
      });
      this.setState({
        goodsOrder
      });
    }
  
    render() {
      const columns = [
        {
          title: '商品',
          dataIndex: 'name',
          key: 'name',
          render: text => <a>{text}</a>,
        },
        {
          title: '数量',
          dataIndex: 'amount',
          key: 'amount',
          render: number => <InputNumber value={number} />
        },
        {
          title: 'Action',
          key: 'action',
          render: (text, record) => (
            <Space size="middle">
              <a>Delete</a>
            </Space>
          ),
        },
      ];
  
      const content = (
        <div>
          <Table columns={columns} dataSource={this.state.goodsOrder} />
          <button onClick={() => this.createOrder()}>立即下单</button>
          <button>清空</button>
        </div>
      );
  
      return (
        <div>
          {this.state.goods.map((good, index) => (
            <div className="good" key={index}>
              <img src={good.imgUrl} alt=""/>
              <span>{good.name}</span>
              <span>单价{good.price}元/{good.unit}</span>
              <button onClick={() => this.addGoods(good)}>+</button>
            </div>
          ))}
  
          <Popover content={content}>
            <Button type="primary">购物车</Button>
          </Popover>
        </div>
      );
    }
  }
  
export default Mall;