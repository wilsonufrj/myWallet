import { createStore } from "@reduxjs/toolkit";
import { gainsReducer } from "./gainsReducer";

export const store = createStore(gainsReducer);