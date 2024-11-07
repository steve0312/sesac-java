import React from "react";

export default function Login() {
  let isLoged = true;

  return <div>{isLoged ? "환영합니다!" : "로그인이 필요합니다"}</div>;
}