import { createStore } from "@reduxjs/toolkit";
import { gainReducer } from "../reducers/gainReducer";

export const store = createStore(gainReducer);